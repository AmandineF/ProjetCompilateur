entete
max:
ouvbloc 2
iload 4
istore -6
iload -6
iload 6
isup
iffaux SINON1
iload -6
ireturn 8

goto FSI1
SINON1:
iload 6
ireturn 8

FSI1:
fermebloc 4

min:
ouvbloc 0
iload 4
iload 6
iinf
iffaux SINON2
iload 4
ireturn 8

goto FSI2
SINON2:
iload 6
ireturn 8

FSI2:
fermebloc 4

sup:
ouvbloc 0
iload 4
iload 6
ireturn 8

fermebloc 4

ouvbloc 4
iconst 5
istore -8
lireEnt -10
aLaLigne
reserveRetour

iload -8
reserveRetour

iload -10
iconst 5
call min

iload -10
call max

iload -10
iconst 2
iadd
istore -12
reserveRetour

iconst 1
reserveRetour

iload -8
iload -10
iconst 5
isub
call max

iload -10
isub
reserveRetour

iload -8
iconst 2
imul
iload -10
call min

iload -10
call sup

iload -10
istore -14
aLaLigne
iload -12
ecrireEnt
aLaLigne
iload -14
ecrireEnt
queue
