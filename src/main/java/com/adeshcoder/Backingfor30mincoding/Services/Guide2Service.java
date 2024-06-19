package com.adeshcoder.Backingfor30mincoding.Services;

import com.adeshcoder.Backingfor30mincoding.Entities.Guide2;
import com.adeshcoder.Backingfor30mincoding.payloads.GuideDto;


import java.util.List;

public interface Guide2Service {
    Guide2 createGuide(GuideDto guideDto);
    Guide2 updateGuide(Integer guideId,GuideDto guideDto);

    void DeleteGuide(Integer guideId);

    List<Guide2> getAllGuide();

    Guide2 getGuide(Integer guideId);
}
