package view;
/**
 * This is an enum class that represents all the
 * Civilizations that the user may chose from
 */
public enum CivEnum {

    ANCIENT_EGYPT {
        @Override
        public String toString() {
            return "Ancient Egypt";
        }
    },
    QIN_DYNASTY {
        @Override
        public String toString() {
            return "Qin Dynasty";
        }
    },
    ROMAN_EMPIRE {
        @Override
        public String toString() {
            return "Roman Empire";
        }
    },
    AMERICAN_EMPIRE {
        @Override
        public String toString() {
            return "American Empire";
        }
    },
    FUTURELAND_EMPIRE {
        @Override
        public String toString() {
            return "Futureland Empire";
        }
    },
    BLUEPRINT_EMPIRE {
        @Override
        public String toString() {
            return "BluePrint Empire";
        }
    },
}