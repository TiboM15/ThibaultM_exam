package fr.MEGEMONT_Thibault.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.MEGEMONT_Thibault.exam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private String name;
}