package restassured;

import helpers.GraphQLQuery;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test01_GraphQL {

    @Test
    public void getMovieNameTest() {
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("{ film(id: \"ZmlsbXM6MQ\") { director title id }}");

        given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("https://swapi-graphql.netlify.app/.netlify/functions/index")
                .then()
                .assertThat()
                .body("data.film.title", equalTo("A New Hope"));
    }
}
