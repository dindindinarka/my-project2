package docs.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseTypes {
        UPDATED(" - updated"),
        USERWRONG(" - wrong user"),
        STATUSWRONG(" - documents is sent"),
        DELETEDATWRONG(" - documents is deletedt");

        private final String type;


}
