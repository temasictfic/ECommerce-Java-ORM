package com.tobeto.pairwork_orm.services.dtos.customerDtos.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

	private int customerId;

	@Pattern(regexp = "\\+\\d{10,15}", message = "Telefon numarası geçerli bir formatta olmalıdır (+90XXXXXXXXXX gibi).")
	private String phoneNumber;
	
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "İsim sadece harf ve boşluk içermelidir.")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "Soyisim sadece harf içermelidir.")
	private String lastName;
	
	@Past(message = "Doğum tarihi geçmiş bir tarih olmalıdır.")
	private LocalDate birthDate;
}
