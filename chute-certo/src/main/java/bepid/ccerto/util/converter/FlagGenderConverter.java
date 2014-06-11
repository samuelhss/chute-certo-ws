package bepid.ccerto.util.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import bepid.ccerto.user.domain.Gender;

@Converter(autoApply = true)
public class FlagGenderConverter implements AttributeConverter<Gender, String> {
	
	public String convertToDatabaseColumn(Gender gender) {
		return gender.getId();
	}

	public Gender convertToEntityAttribute(String value) {
		return Gender.FEMALE.getId().equals(value) ? Gender.FEMALE : Gender.MALE;
	}

}