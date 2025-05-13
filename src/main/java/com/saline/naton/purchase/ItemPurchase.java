package com.saline.naton.purchase;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ITEMPURCHASE")
@Getter
@Setter
public class ItemPurchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Purchase purchase;
	private Long idProduct;
	private Long quantity;
}
