package contracts

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    description "should return first person"
    request{
        method GET()
        url("/person/1") {
            queryParameters {
                parameter("id", "1")
            }
        }
    }
    response {
        body(
                "ok"
        )
        status 200
    }
}