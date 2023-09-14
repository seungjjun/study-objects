package main.java.chapter04;

import java.time.LocalDateTime;

public class Screening {
    private final Movie movie;
    private final int sequence;
    private final LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount);
                }
            }
            case PERCENT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount);
                }
            }
            case NONE_DISCOUNT -> {
                return movie.calculateNoneDiscountedFee().times(audienceCount);
            }
        }

        return movie.calculateNoneDiscountedFee().times(audienceCount);
    }
}
