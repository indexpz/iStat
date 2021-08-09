package pl.indexpz.iStat.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.indexpz.iStat.domain.model.MeterRecord;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.repository.MeterRepository;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.domain.service.MeterService;
import pl.indexpz.iStat.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor //zamiast konstruktora
public class MeterServiceImpl implements MeterService {

    private final UserRepository userRepository;
    private final MeterRepository meterRepository;

    @Override
    @Transactional
    public MeterRecord addMeter(MeterRecord meterToAdd) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).get();
        meterToAdd.setUser(user);
        return meterRepository.save(meterToAdd);
    }

    @Override
    public List<MeterRecord> getMeters() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return meterRepository.findAllByUserUsername(username);
    }

    @Override
    public MeterRecord getMeterById(Long id) {
        return meterRepository.findById(id).orElseThrow((()->new ResourceNotFoundException("Meter with id " + id + " not exist.")));
    }

    @Override
    public MeterRecord getMeterByMeterName(String meterName) {
        MeterRecord meter = meterRepository.findMeterByMeterName(meterName);
        return meter;
    }


    @Override
    public void updateMeter(MeterRecord meter) {

    }

    @Override
    public void removeMeter(MeterRecord meter) {

    }
}
