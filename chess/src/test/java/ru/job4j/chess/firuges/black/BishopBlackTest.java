package ru.job4j.chess.firuges.black;

import org.junit.Test;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A6);
        Cell rsl = bishopBlack.position();
        assertThat(rsl, is(Cell.A6));

    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] ps = new Cell[4];
        ps[0] = Cell.D2;
        ps[1] = Cell.E3;
        ps[2] = Cell.F4;
        ps[3] = Cell.G5;
        Cell[] rsl = bishopBlack.way(Cell.G5);
        assertThat(rsl, is(ps));
    }

    @Test
    public void testWayNotDiagonal()  {
        try {
            BishopBlack bishopBlack = new BishopBlack(Cell.C1);
            Cell[] rsl = bishopBlack.way(Cell.G6);
            fail();
        } catch (ImpossibleMoveException e) {
            assertThat(e.getMessage(), is("Could not move by diagonal from C1 to G6"));
        }

    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A6);
        Figure newBishopBlack = bishopBlack.copy(Cell.A7);
        Cell rsl = newBishopBlack.position();
        assertThat(rsl, is(Cell.A7));
    }

}