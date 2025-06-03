package org.example.api;

import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.example.model.Item;
import org.example.utils.LoggerUtil;
import org.example.utils.RequestBuilder;

public class ObjectApi {
    private static final String BASE_URL = "https://api.restful-api.dev/objects";
    private static final Logger logger = LoggerUtil.getLogger(ObjectApi.class);

    /**
     * Create a new item.
     *
     * @param item Item to be created
     * @return API Response
     */
    public Response createItem(Item item) {
        try {
            logger.info("Creating item: {}", item.getName());
            Response response = RequestBuilder.getRequest()
                    .body(item)
                    .post(BASE_URL);

            logger.info("Create item response: {}", response.asPrettyString());
            return response;
        } catch (Exception e) {
            logger.error("Error while creating item", e);
            throw new RuntimeException("Failed to create item", e);
        }
    }

    /**
     * Get an item by ID.
     *
     * @param id ID of the item
     * @return API Response
     */
    public Response getItem(String id) {
        try {
            logger.info("Fetching item with ID: {}", id);
            Response response = RequestBuilder.getRequest()
                    .get(BASE_URL + "/" + id);

            logger.info("Get item response: {}", response.asPrettyString());
            return response;
        } catch (Exception e) {
            logger.error("Error while getting item", e);
            throw new RuntimeException("Failed to get item", e);
        }
    }

    /**
     * List all items.
     *
     * @return API Response
     */
    public Response listItems() {
        try {
            logger.info("Fetching all items");
            Response response = RequestBuilder.getRequest()
                    .get(BASE_URL);

            logger.info("List items response: {}", response.asPrettyString());
            return response;
        } catch (Exception e) {
            logger.error("Error while listing items", e);
            throw new RuntimeException("Failed to list items", e);
        }
    }

    /**
     * Delete an item by ID.
     *
     * @param id ID of the item
     * @return API Response
     */
    public Response deleteItem(String id) {
        try {
            logger.info("Deleting item with ID: {}", id);
            Response response = RequestBuilder.getRequest()
                    .delete(BASE_URL + "/" + id);

            logger.info("Delete item response: {}", response.asPrettyString());
            return response;
        } catch (Exception e) {
            logger.error("Error while deleting item", e);
            throw new RuntimeException("Failed to delete item", e);
        }
    }


}
