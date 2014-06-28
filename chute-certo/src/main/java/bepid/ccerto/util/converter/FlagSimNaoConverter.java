package bepid.ccerto.util.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FlagSimNaoConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean value) {
		return (value != null && value) ? "S" : "N";
	}

	@Override
	public Boolean convertToEntityAttribute(String value) {
		return "S".equals(value);
	}

}