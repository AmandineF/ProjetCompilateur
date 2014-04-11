;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE

valeurde:
;ouvbloc 0
enter 0,0
;iLoad
push word ptr [bp+4]

;iConst
push word ptr 1

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iConst
push word ptr 100

;ireturn 6
pop ax
mov [bp+6],ax

;goto FSI1
jmp FSI1

SINON1:
;iLoad
push word ptr [bp+4]

;iConst
push word ptr 2

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iffaux SINON2
pop ax
cmp ax,0
je SINON2

;iConst
push word ptr 50

;ireturn 6
pop ax
mov [bp+6],ax

;goto FSI2
jmp FSI2

SINON2:
;iLoad
push word ptr [bp+4]

;iConst
push word ptr 3

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iffaux SINON3
pop ax
cmp ax,0
je SINON3

;iConst
push word ptr 20

;ireturn 6
pop ax
mov [bp+6],ax

;goto FSI3
jmp FSI3

SINON3:
;iLoad
push word ptr [bp+4]

;iConst
push word ptr 4

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iffaux SINON4
pop ax
cmp ax,0
je SINON4

;iConst
push word ptr 10

;ireturn 6
pop ax
mov [bp+6],ax

;goto FSI4
jmp FSI4

SINON4:
;iLoad
push word ptr [bp+4]

;iConst
push word ptr 5

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iffaux SINON5
pop ax
cmp ax,0
je SINON5

;iConst
push word ptr 5

;ireturn 6
pop ax
mov [bp+6],ax

;goto FSI5
jmp FSI5

SINON5:
;iLoad
push word ptr [bp+4]

;iConst
push word ptr 6

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iffaux SINON6
pop ax
cmp ax,0
je SINON6

;iConst
push word ptr 2

;ireturn 6
pop ax
mov [bp+6],ax

;goto FSI6
jmp FSI6

SINON6:
;iLoad
push word ptr [bp+4]

;iConst
push word ptr 7

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iffaux SINON7
pop ax
cmp ax,0
je SINON7

;iConst
push word ptr 1

;ireturn 6
pop ax
mov [bp+6],ax

;goto FSI7
jmp FSI7

SINON7:
FSI7:

FSI6:

FSI5:

FSI4:

FSI3:

FSI2:

FSI1:

;fermebloc 2
leave
ret 2

nbc:
;ouvbloc 6
enter 6,0
;iLoad
push word ptr [bp+6]

;iConst
push word ptr 0

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6

;iffaux SINON8
pop ax
cmp ax,0
je SINON8

;iConst
push word ptr 1

;iStore
pop ax
mov word ptr [bp-4],ax

;goto FSI8
jmp FSI8

SINON8:
;iLoad
push word ptr [bp+6]

;iConst
push word ptr 0

;iinf
pop bx
pop ax
cmp ax,bx
jge $+6
push -1
jmp $+4
push 0

;iLoad
push word ptr [bp+4]

;iConst
;iConst
;iStore
;iLoad
;call ;iStore
