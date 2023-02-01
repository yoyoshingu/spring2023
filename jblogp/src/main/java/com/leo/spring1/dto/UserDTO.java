package com.leo.spring1.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@NotNull(message="Username이 전달되지 않았음")
	@NotBlank(message="Username은 필수입력 항목임")
	@Size(min=1, max=20, message="Username은 한글자이상 20글자 미만으로")
	private String username;
	
	@NotNull(message="Email이 전달되지 앟음")
	@NotBlank(message="Email은 필수입력 항목임")
	@Email(message="Email형시이 아님")
	private String email;
}
