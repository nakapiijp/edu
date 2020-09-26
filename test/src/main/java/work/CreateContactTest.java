package work;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Locale;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.BeforeClass;
import org.junit.Test;

public class CreateContactTest {
	@BeforeClass
	public static void beforeClass() {
		// localeの設定によってエラーメッセージが異なる。
		Locale.setDefault(Locale.US);//e.g. must not be blank
		//Locale.setDefault(Locale.JAPAN);//e.g.  空白は許可されていません
	}

	@Test
	public void test_validate() {
		// Given
		final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		final CreateContact createContact = CreateContact
				.builder()
				.uid(null) // @NotBlankが定義されているためnullでなければならない。(エラー値の設定)
				.contact("000")
				.contactType(ContactType.PHONE_NUMBER)
				.build();

		// When
		final Collection<ConstraintViolation<CreateContact>> constraintViolations = validator.validate(createContact);

		// Then
		// ConstraintViolationエラーに対する情報が記される。
		//エラー個数の判定
		assertEquals(1, constraintViolations.size());
		//エラーメッセージの判定
		assertEquals("must not be blank", constraintViolations.iterator().next().getMessage());
		//エラーメッセージの表示
		for( ConstraintViolation<CreateContact> cv: constraintViolations) {
			System.out.println(cv.getMessage());
		}
	}
}