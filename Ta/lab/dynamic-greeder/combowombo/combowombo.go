package combowombo

type ComboWombo struct {
	memory map[calcParam]uint64
}

type calcParam struct {
	top int
	bot int
}

func NewComboWombo() *ComboWombo {
	return &ComboWombo{memory: map[calcParam]uint64{}}
}

func (comb *ComboWombo) Calc(top, bot int) uint64 {
	if top > bot {
		return 0
	}
	if top == bot {
		return 1
	}
	if top == 0 {
		return 1
	}
	param := calcParam{
		top: top,
		bot: bot,
	}
	combination := comb.memory[param]
	if combination != 0 {
		return combination
	}
	combination = comb.Calc(top, bot-1) + comb.Calc(top-1, bot-1)
	comb.memory[param] = combination

	return combination
}
