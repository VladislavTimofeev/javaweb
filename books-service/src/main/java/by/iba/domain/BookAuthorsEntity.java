package by.iba.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthorsEntity {

    private Long id;
    private Long bookId;
    private Long authorId;

}
