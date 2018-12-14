# PercSymbol

A class that returns associated MIDI notes according to General MIDI Level 2.

## Installation

a/ Clone this repository to your computer and copy the directory to the `Extension` directory (The path can be found by evaluating `Platform.userExtensionDir` or `Platform.systemExtensionDir`).

b/ Execute this -> `Quarks.install("https://github.com/lvm/PercSymbol");`

## Usage

```
Pseq(['bd', \sn, \ch], inf).asStream.nextN(10);
-> [ 36, 38, 42, 36, 38, 42, 36, 38, 42, 36 ]

PercSymbol(\sn);
-> 38

PercSymbol.oh;
-> 46

PercSymbol([\sn, \bd, \r]);
-> [ 38, 36, Rest(1) ]

PercSymbol([\sn, \bd, [\r, \sn, \ch]]);
-> [ 38, 36, [ Rest(1), 38, 42 ] ]

['bd', \sn, \ch, \rest].asPercSymbol;
-> [ 36, 38, 42, Rest(1) ]

PercSymbol.names;
-> [ abd, ag, bd, be, bt, ca, cas, ch, cl, cow, cp, cr, cr2, cy, esn, gui, hag, hb, hc, hft, hh, hmt, hq, ht, hti, hwb, jb, lag, lb, lc, lft, lgui, lmt, lt, lti, lwb, lwi, ma, mb, mc, mcl, mhc, ms, mt, oc, oh, ohc, os, ot, ph, ri, ri2, rm, scr, scy, sgui, sha, sl, sn, spl, sps, sqc, st, sti, swi, ta, vib, whi ]

PercSymbol.directory;
-> abd: MIDI Note 35
ag: MIDI Note 68
bd: MIDI Note 36
be: MIDI Note 53
bt: MIDI Note 84
ca: MIDI Note 69
...
```

## Reference

* https://www.midi.org/specifications/item/gm-level-1-sound-set
* https://en.wikipedia.org/wiki/General_MIDI_Level_2#Drum_sounds

## License

[LICENSE](LICENSE)
