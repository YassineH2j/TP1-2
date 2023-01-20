package com.example.demo.service;

        import com.example.demo.entity.CoversionOperation;
        import com.example.demo.repository.ConversionOperationRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class ConversionOperationService {
    @Autowired
    ConversionOperationRepository conversionOperationRepository;

    public List<CoversionOperation> get () {
        return conversionOperationRepository.findAll();
    }

    public CoversionOperation create(CoversionOperation x){
        return conversionOperationRepository.save(x);
    }

    public void delete(Long id){
        conversionOperationRepository.deleteById(id);
    }

    public CoversionOperation update(Long id, CoversionOperation coversionOperation){
        CoversionOperation operation = conversionOperationRepository.findById(id).get();
        operation.setOperationId(coversionOperation.getOperationId());
        operation.setCurrencyFrom(coversionOperation.getCurrencyFrom());
        operation.setCurrencyTo(coversionOperation.getCurrencyTo());
        operation.setInitialAmount(coversionOperation.getInitialAmount());
        operation.setConvertedAmount(coversionOperation.getConvertedAmount());
        return conversionOperationRepository.save(operation);
    }
}