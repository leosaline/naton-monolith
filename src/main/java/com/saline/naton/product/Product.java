package com.saline.naton.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PRODUCT")
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private PackageTypeEnum packageType;
	private Long company;
	@Transient
	private String companyName;
}
