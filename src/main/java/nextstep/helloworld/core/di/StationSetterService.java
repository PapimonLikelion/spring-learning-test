package nextstep.helloworld.core.di;

import org.springframework.stereotype.Component;

@Component
public class StationSetterService {
    private StationRepository stationRepository;

    public StationSetterService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public String sayHi() {
        return stationRepository.sayHi();
    }
}
