package com.tobeto.pairwork_orm.services.dtos.customerDtos.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
	
	@Size(min = 4, max = 20, message = "Kullanıcı adı en az 4, en fazla 20 karakter olmalıdır.")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Kullanıcı adı sadece harf, sayı, - ve _ karakterlerini içermelidir.")
	private String username;

	@Email(message = "Geçerli bir email formatı giriniz.")
	private String email;
	
	@NotBlank(message = "Şifre boş olamaz!")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "Şifre en az 8 karakter uzunluğunda olmalı ve en az bir büyük harf, bir küçük harf ve bir sayı içermelidir.")
	private String password;
	
	@Pattern(regexp = "\\+\\d{10,15}", message = "Telefon numarası geçerli bir formatta olmalıdır (+90XXXXXXXXXX gibi).")
	private String phoneNumber;
	
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "İsim sadece harf ve boşluk içermelidir.")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "Soyisim sadece harf içermelidir.")
	private String lastName;
	
	@Past(message = "Doğum tarihi geçmiş bir tarih olmalıdır.")
	private LocalDate birthDate;
}
