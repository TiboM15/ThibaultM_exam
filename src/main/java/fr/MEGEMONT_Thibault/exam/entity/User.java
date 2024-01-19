package fr.MEGEMONT_Thibault.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.MEGEMONT_Thibault.exam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private Date createdAt;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private String email;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private String password;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private String roles;

    @OneToMany(mappedBy = "user")
    @JsonView(JsonViews.UserListView.class)
    private List<Listing> listings = new ArrayList<>();
}