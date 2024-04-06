package com.tobeto.pairwork_orm.services.dtos.sellerDtos.requestes;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSellerRequest {
	
	private int sellerId;
	
	@Pattern(regexp = "\\+\\d{10,15}", message = "Telefon numarası geçerli bir formatta olmalıdır (+90XXXXXXXXXX gibi).")
	private String phoneNumber;
	
	@Size(min = 4, max = 50, message = "Kullanıcı adı en az 4, en fazla 50 karakter olmalıdır.")
	@Pattern(regexp = "^[a-zA-Z0-9ğüşıöçĞÜŞİÖÇ\\s\\-.]+$", message = "Geçerli bir şirket ismi giriniz.")
	@Column(name = "company_name")
    private String companyName;
    
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "İsim sadece harf ve boşluk içerebilir.")
    @Column(name = "contact_name")
    private String contactName;

	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s\\-.]+$", message = "Geçerli bir iş unvanı giriniz.")
    @Column(name = "contact_title")
    private String contactTitle;

	@Pattern(regexp = "^(http://|https://)?(www\\.)?[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$",
			message = "Geçersiz website URL formatı")
    @Column(name = "website")
    private String website;
    
    @Column(name = "tax_number")
    private String taxNumber;
}
