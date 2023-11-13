package com.jsp.workZone.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Floor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int floor_Number;
	
	
    @OneToMany(cascade = CascadeType.ALL) // Apply cascading to the "WorkSpace" association
    @Enumerated(EnumType.STRING) // Map the enum as a string
    @Column(columnDefinition = "ENUM")
    private List<WorkSpace> spaces;

    //@Column(columnDefinition = "ENUM('ACTIVE', 'INACTIVE', 'PENDING')")
}
