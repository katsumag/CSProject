class Binary:

    def to_denary(self, binary):
        return self._find_denary_value(binary, self._calculate_bases(binary))

    def to_denary_first_negative(self, binary):
        return self._find_denary_value(binary, self._flip_first(self._calculate_bases(binary)))

    def to_denary_reciprocals(self, binary):
        return self._find_denary_value(binary, self._reciprocal_bases(binary))

    def _reciprocal_bases(self, binary):
        bases = self._calculate_bases(binary + "0")  # gain an extra value so it produces the right scale when 1 is removed
        bases.reverse()
        del bases[0]
        return [1 / base for base in bases]

    def _calculate_bases(self, binary):
        bases = [2 ** x for x in range(len(binary))]
        bases.reverse()
        return bases

    def _flip_first(self, listt):
        listt[0] *= -1
        return listt

    def _find_denary_value(self, binary, bases):
        total = 0
        table = zip(binary, bases)
        for pair in table:
            if int(pair[0]) == 1:
                total += pair[1]
        return total
