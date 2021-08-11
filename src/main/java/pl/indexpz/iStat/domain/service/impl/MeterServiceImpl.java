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
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
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
        return meterRepository.findAllByUserUsername(username);
    }

    @Override
    public Optional<Meter> getMeterById(Long meterId) {
        return meterRepository.findById(meterId);
    }

    @Override
    public Meter getMeterByMeterName(String meterName) {
        Meter meter = meterRepository.findMeterByMeterName(meterName);
        return meter;
    }


    @Override
    public void updateMeter(Meter meterToUpdate) {
        Optional<Meter> optionalMeter = getMeterById(meterToUpdate.getId());
        if (optionalMeter.isPresent()) {
            Meter meter = optionalMeter.get();
            meter.setMeterName(meterToUpdate.getMeterName());
            meter.setUnit(meterToUpdate.getUnit());
            meter.setDescription(meterToUpdate.getDescription());
            meterRepository.save(meter);
        }else{
            Meter meter = new Meter();
        }

    }

    @Override
    public void removeMeter(Meter meterToDelete) {
        Optional<Meter> optionalMeter = getMeterById(meterToDelete.getId());
        if(optionalMeter.isPresent()){
            Meter meter = optionalMeter.get();
            meterRepository.delete(meter);
        }else{
            Meter meter = new Meter();
        }
    }
}
