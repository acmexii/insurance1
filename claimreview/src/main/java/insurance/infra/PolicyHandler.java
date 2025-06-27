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

    @Autowired
    ReviewRepository reviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ClaimRequested'"
    )
    public void wheneverClaimRequested_StartReview(
        @Payload ClaimRequested claimRequested
    ) {
        ClaimRequested event = claimRequested;
        System.out.println(
            "\n\n##### listener StartReview : " + claimRequested + "\n\n"
        );

        // Comments //
        //사전 조건 : 고객의 클레임이 청구된 상태
        // 시스사후 상태 : 심사 상태는 '심사 대기' 를 갖는다.
        // 3. AI가 조건에 맞은 처리한다.

        // Sample Logic //
        Review.startReview(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
