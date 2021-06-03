package com.example.demo;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exceptions.ForbiddenException;
import com.example.demo.validations.InfoValidator;
import com.example.demo.validations.MutantValidator;
import com.example.demo.data.DnaValidationRequest;
import com.example.demo.data.MutanteValidatorResponse;




@RestController
public class MutantController {
;

@PostMapping("/mutant")
public MutanteValidatorResponse mutant(@RequestBody DnaValidationRequest dnaValidationRequest) {
		
		InfoValidator infoValidator = new InfoValidator();
		boolean isDnaValid = infoValidator.isDnaValid(dnaValidationRequest.dna);
		if(!isDnaValid) {
			return new MutanteValidatorResponse("Información de ADN incorrecta");
		}
		
		MutantValidator mutantValidator = new MutantValidator();
		boolean isMutant = mutantValidator.isMutant(dnaValidationRequest.dna);
		
		if(isMutant) {
			return new MutanteValidatorResponse("ADN mutante!!!!");
		}else {
			throw new ForbiddenException();
		}
	}
}
