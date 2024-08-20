package com.puru.ipd.entity.master;

import com.puru.config.Auditable;
import jakarta.persistence.*;

@Entity
@Table(indexes = {
		@Index(name = "idx_serviceId", columnList = "serviceId"),
})
public class CommentSuggestion extends Auditable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String text;

	private long serviceId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public CommentSuggestion() {
		super();
	}

	public CommentSuggestion(long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

}
