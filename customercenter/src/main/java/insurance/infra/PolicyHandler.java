package insurance.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import insurance.config.kafka.KafkaProcessor;
import insurance.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ClaimRequested'"
    )
    public void wheneverClaimRequested_Inform(
        @Payload ClaimRequested claimRequested
    ) {
        ClaimRequested event = claimRequested;
        System.out.println(
            "\n\n##### listener Inform : " + claimRequested + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ClaimRequested'"
    )
    public void wheneverClaimRequested_고객알림(
        @Payload ClaimRequested claimRequested
    ) {
        ClaimRequested event = claimRequested;
        System.out.println(
            "\n\n##### listener 고객알림 : " + claimRequested + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
