import Binary


def insert_string(insert, index, string):
    return string[:index] + insert + string[index:]


def shift_point(mantissa, exponent):
    parts = mantissa.split(".")
    return parts[0] + insert_string(".", exponent, parts[1])


def twos_complement(mantissa, exponent):
    exponent = Binary.Binary().to_denary_first_negative(exponent)
    mantissa = shift_point(mantissa, exponent)

    parts = mantissa.split(".")
    first = Binary.Binary().to_denary_first_negative(parts[0])
    second = Binary.Binary().to_denary_reciprocals(parts[1])

    return first + second


if __name__ == '__main__':
    print(twos_complement("1.0101", "0010"))
    print(twos_complement("1.000010100", "0101"))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
