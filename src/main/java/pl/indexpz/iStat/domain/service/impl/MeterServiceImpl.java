package pl.indexpz.iStat.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.iStat.domain.model.Meter;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.repository.MeterRepository;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.domain.service.MeterService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor //zamiast konstruktora
public class MeterServiceImpl implements MeterService {

    private final UserRepository userRepository;
    private final MeterRepository meterRepository;

    @Override
    @Transactional
    public Meter addMeter(Meter meterToAdd) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).get();
        meterToAdd.setUser(user);
        return meterRepository.save(meterToAdd);
    }

    @Override
    public List<Meter> getMeters() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return null;
    }

    @Override
    public Meter getMeterById(Long id) {
        return null;
    }

    @Override
    public Meter getMeterByMeterName(String meterName) {
        return null;
    }

    @Override
    public void updateMeter(Meter meter) {

    }

    @Override
    public void removeMeter(Meter meter) {

    }
}
