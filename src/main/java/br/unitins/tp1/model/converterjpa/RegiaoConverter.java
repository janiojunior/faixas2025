package br.unitins.tp1.model.converterjpa;

import br.unitins.tp1.model.Regiao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RegiaoConverter implements AttributeConverter<Regiao, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Regiao regiao) {
        return regiao == null ? null : regiao.getId();

    }

    @Override
    public Regiao convertToEntityAttribute(Integer id) {
        return Regiao.valueOf(id);
    }
    
}
