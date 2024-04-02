package com.tobeto.pairwork_orm.core.utilities.exceptions.problemdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
	private String title;
    private String detail;
    private String type;
}
