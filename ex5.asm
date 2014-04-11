;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE

dessin:
;ouvbloc 12
enter 12,0
;iConst
push word ptr 0

;iStore
pop ax
mov word ptr [bp-8],ax

;iLoad
push word ptr [bp+4]

;iConst
push word ptr -1

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iConst
push word ptr 0

;iStore
pop ax
mov word ptr [bp-2],ax

;goto FSI1
jmp FSI1

SINON1:
;iLoad
push word ptr [bp+6]

;iConst
push word ptr 2

;isub
pop bx
pop ax
sub ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-2],ax

FSI1:

FAIRE1:
;iLoad
push word ptr [bp-2]

;iLoad
push word ptr [bp+6]

;iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

;iffaux FAIT1
pop ax
cmp ax,0
je FAIT1

;iConst
push word ptr 0

;iStore
pop ax
mov word ptr [bp-4],ax

FAIRE2:
;iLoad
push word ptr [bp-4]

;iLoad
push word ptr [bp-2]

;iinf
pop bx
pop ax
cmp ax,bx
jge $+6
push -1
jmp $+4
push 0

;iffaux FAIT2
pop ax
cmp ax,0
je FAIT2

;iLoad
push word ptr [bp-4]

;iLoad
push word ptr [bp-4]

;iConst
push word ptr 2

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;iConst
push word ptr 2

;imul
pop bx
pop ax
imul bx
push ax

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0

;iffaux SINON2
pop ax
cmp ax,0
je SINON2

;ecrireChaine
.DATA
mess0 DB "*$"
.CODE
lea dx,mess0
push dx
call ecrch

;goto FSI2
jmp FSI2

SINON2:
;ecrireChaine
.DATA
mess1 DB " $"
.CODE
lea dx,mess1
push dx
call ecrch

FSI2:

;iLoad
push word ptr [bp-4]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-4],ax

;goto FAIRE2
jmp FAIRE2

FAIT2:
;iLoad
push word ptr [bp-2]

;iStore
pop ax
mov word ptr [bp-4],ax

FAIRE3:
;iLoad
push word ptr [bp-4]

;iLoad
push word ptr [bp+6]

;iinf
pop bx
pop ax
cmp ax,bx
jge $+6
push -1
jmp $+4
push 0

;iffaux FAIT3
pop ax
cmp ax,0
je FAIT3

;iLoad
push word ptr [bp-4]

;iLoad
push word ptr [bp-4]

;iConst
push word ptr 3

;idiv
pop bx
pop ax
cwd
 idiv bx
push ax

;iConst
push word ptr 3

;imul
pop bx
pop ax
imul bx
push ax

;idiff
pop bx
pop ax
cmp ax,bx
je $+6
push -1
jmp $+4
push 0

;iffaux SINON3
pop ax
cmp ax,0
je SINON3

;ecrireChaine
.DATA
mess2 DB "-$"
.CODE
lea dx,mess2
push dx
call ecrch

;goto FSI3
jmp FSI3

SINON3:
;ecrireChaine
.DATA
mess3 DB " $"
.CODE
lea dx,mess3
push dx
call ecrch

FSI3:

;iLoad
push word ptr [bp-4]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-4],ax

;goto FAIRE3
jmp FAIRE3

FAIT3:
;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-8]

;iLoad
push word ptr [bp-2]

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-8],ax

;iLoad
push word ptr [bp-2]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-2],ax

;goto FAIRE1
jmp FAIRE1

FAIT1:
;iLoad
push word ptr [bp-8]

;ireturn 8
pop ax
mov [bp+8],ax

;fermebloc 4
leave
ret 4

debut :
STARTUPCODE

main:
;ouvbloc 4
enter 4,0
;lireEnt
lea dx,[bp-4]
push dx
call lirent

;aLaLigne
call ligsuiv

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp-4]

;iConst
push word ptr -1

;call dessin
call dessin

;iStore
pop ax
mov word ptr [bp-2],ax

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-2]

;ecrireEnt
call ecrent

;queue
nop
EXITCODE
end