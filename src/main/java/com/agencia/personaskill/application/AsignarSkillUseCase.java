package com.agencia.personaskill.application;

import com.agencia.personaskill.domain.entity.AsignarSkill;
import com.agencia.personaskill.domain.service.AsignarSkillService;
import com.agencia.skills.domain.entity.Skill;

public class AsignarSkillUseCase {

    private final AsignarSkillService asignarSkillService;

    public AsignarSkillUseCase(AsignarSkillService asignarSkillService) {
        this.asignarSkillService = asignarSkillService;
    }

    public void execute(Skill skill){
        asignarSkillService.asignarSkill(skill);
    }

    

}
