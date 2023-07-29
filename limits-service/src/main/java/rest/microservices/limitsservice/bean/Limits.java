package rest.microservices.limitsservice.bean;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Limits {
    private int min;
    private int max;

}
