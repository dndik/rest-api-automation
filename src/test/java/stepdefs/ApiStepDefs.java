package stepdefs;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.example.api.ObjectApi;
import org.example.model.Item;
import org.example.utils.TestContext;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiStepDefs {


    private final ObjectApi objectApi = new ObjectApi();
    private static final String ITEM_KEY = "item";
    private static final String RESPONSE_KEY = "response";
    private static final String OBJECT_ID_KEY = "objectId";

    @Given("I create an object with:")
    public void i_create_an_object_with(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        Map<String, String> modifiableMap = new HashMap<>(map); // Clone to avoid UnsupportedOperationException
        String name = modifiableMap.remove("name");
        Item item = new Item(name, modifiableMap);
        TestContext.put(ITEM_KEY, item);
    }

    @When("I send a POST request to add the object")
    public void i_send_a_post_request_to_add_the_object() {
        Item item = (Item) TestContext.get(ITEM_KEY);
        Response response = objectApi.createItem(item);
        TestContext.put(RESPONSE_KEY, response);

        String id = response.jsonPath().getString("id");
        System.out.println(id);
        TestContext.put(OBJECT_ID_KEY, id);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedCode) {
        Response response = (Response) TestContext.get(RESPONSE_KEY);
        assertThat(response.statusCode(), is(expectedCode));
    }

    @Then("the response should contain the object name {string}")
    public void the_response_should_contain_the_object_name(String expectedName) {
        Response response = (Response) TestContext.get(RESPONSE_KEY);
        String actualName = response.jsonPath().getString("name");
        assertThat(actualName, equalTo(expectedName));
    }

    @And("I store the object ID")
    public void i_store_the_object_id() {
        Response response = (Response) TestContext.get(RESPONSE_KEY);
        String id = response.jsonPath().getString("id");
        assertThat("Object ID is null", id, notNullValue());
        TestContext.put(OBJECT_ID_KEY, id);
    }

    @When("I send a GET request for the object by ID")
    public void i_send_a_get_request_for_the_object_by_id() {
        String id = (String) TestContext.get(OBJECT_ID_KEY);
        Response response = objectApi.getItem(id);
        TestContext.put(RESPONSE_KEY, response);
    }

    @When("I send a DELETE request for the object by ID")
    public void i_send_a_delete_request_for_the_object_by_id() {
        String id = (String) TestContext.get(OBJECT_ID_KEY);
        Response response = objectApi.deleteItem(id);
        TestContext.put(RESPONSE_KEY, response);
    }

    @Then("the object should no longer exist")
    public void the_object_should_no_longer_exist() {
        String id = (String) TestContext.get(OBJECT_ID_KEY);
        Response response = objectApi.getItem(id);
        assertThat("Expected 404 Not Found", response.statusCode(), is(404));
    }

    @When("I send a GET request to list all objects")
    public void i_send_a_get_request_to_list_all_objects() {
        Response response = objectApi.listItems();
        TestContext.put(RESPONSE_KEY, response);
    }

    @Then("the response should contain a non-empty list of objects")
    public void the_response_should_contain_a_non_empty_list_of_objects() {
        Response response = (Response) TestContext.get(RESPONSE_KEY);
        List<?> list = response.jsonPath().getList("");
        assertThat("Object list is empty", list, is(not(empty())));
    }
}
