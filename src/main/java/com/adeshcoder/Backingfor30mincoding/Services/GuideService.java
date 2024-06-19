package com.adeshcoder.Backingfor30mincoding.Services;

import com.adeshcoder.Backingfor30mincoding.Entities.Guide;
import com.adeshcoder.Backingfor30mincoding.payloads.GuideDto;


import java.util.List;

public interface GuideService {

    Guide createGuide(GuideDto guideDto);
    Guide updateGuide(Integer guideId,GuideDto guideDto);

    void DeleteGuide(Integer guideId);

    List<Guide> getAllGuide();

    Guide getGuide(Integer guideId);
}
