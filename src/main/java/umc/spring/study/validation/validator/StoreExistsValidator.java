package umc.spring.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.study.repository.StoreRepository.StoreRepositoryImpl;
import umc.spring.study.validation.annotation.StoreExists;
@Component
public class StoreExistsValidator implements ConstraintValidator<StoreExists, Long> {

    private final StoreRepositoryImpl storeRepository;

    public StoreExistsValidator(StoreRepositoryImpl storeRepository) {
        this.storeRepository=storeRepository;
    }



    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        //Store ID가 존재하는지 확인한다
        if (storeId == null) {
            return false; // Null 값 허용하지 않음
        }
        return storeRepository.existsById(storeId);
    }
}
