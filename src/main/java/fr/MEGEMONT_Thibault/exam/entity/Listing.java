package fr.MEGEMONT_Thibault.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.MEGEMONT_Thibault.exam.json_views.JsonViews;
import jakarta.persistence.*;
import jakarta.websocket.Decoder;
import lombok.*;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.Text;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private String title;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private String description;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private int producedYear;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private Long mileage;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private double price;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    @CreationTimestamp
    private Date createdAt;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    private String image;

    @JsonView({
            JsonViews.UserListView.class,
            JsonViews.ListingListView.class
    })
    @ManyToOne
    private Model model;

    @ManyToOne
    @JsonView(JsonViews.ListingListView.class)
    private User user;
}