package anhnd.ph30384.asm2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3, message = "Name must be at least 3 characters!")
    private String name;

    private String category;

    @NotNull(message = "Wrong format!")
    private int quantity;

    @NotNull(message = "Wrong format!")
    private int price;
}
