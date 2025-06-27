package insurance.infra;

import insurance.config.kafka.KafkaProcessor;
import insurance.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenClaimRequested_then_CREATE_1(
        @Payload ClaimRequested claimRequested
    ) {
        try {
            if (!claimRequested.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setUserId(claimRequested.getUserId());
            dashboard.setClaimTitle(claimRequested.getClaimTitle());
            dashboard.setClaimId(claimRequested.getId());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReviewCompleted_then_UPDATE_1(
        @Payload ReviewCompleted reviewCompleted
    ) {
        try {
            if (!reviewCompleted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByClaimId(
                reviewCompleted.getClaimId()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setReviewRslt(reviewCompleted.getReviewResult());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
