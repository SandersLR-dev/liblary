package com.library.domain.dto.publisher;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PublisherDto {

    @NotBlank(message = "Name is mandatory")
    String name;
}
