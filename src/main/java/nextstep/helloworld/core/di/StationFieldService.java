package nextstep.helloworld.core.di;

import org.springframework.stereotype.Component;

@Component
public class StationFieldService {
    private StationRepository stationRepository;

    public StationFieldService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public String sayHi() {
        return stationRepository.sayHi();
    }
}
