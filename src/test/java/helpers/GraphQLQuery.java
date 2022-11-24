package helpers;

import lombok.*;

@Data

public class GraphQLQuery {

    private String query;
    private Object variables;
}
