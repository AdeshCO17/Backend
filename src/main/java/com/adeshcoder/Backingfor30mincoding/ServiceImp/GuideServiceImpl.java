package com.adeshcoder.Backingfor30mincoding.ServiceImp;

import com.adeshcoder.Backingfor30mincoding.Entities.Guide;
import com.adeshcoder.Backingfor30mincoding.Services.GuideService;
import com.adeshcoder.Backingfor30mincoding.payloads.GuideDto;
import com.adeshcoder.Backingfor30mincoding.repositories.GuideRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideRepo guideRepo;
    @Override
    public Guide createGuide(GuideDto guideDto) {

        Guide guide=new Guide(guideDto.getTopic(),guideDto.getLink());
        return guideRepo.save(guide);
    }

    @Override
    public Guide updateGuide(Integer guideId, GuideDto guideDto) {

       Guide entity= this.guideRepo.findById(guideId).orElseThrow();
        entity.setTopic(guideDto.getTopic());
       entity.setLink(guideDto.getLink());

        return this.guideRepo.save(entity);
    }

    @Override
    public void DeleteGuide(Integer guideId) {

        Guide entity=this.guideRepo.findById(guideId).orElseThrow();
        guideRepo.delete(entity);

    }

    @Override
    public List<Guide> getAllGuide() {
        return this.guideRepo.findAll();
    }

    @Override
    public Guide getGuide(Integer guideId) {
        return guideRepo.findById(guideId).orElseThrow();
    }
}
