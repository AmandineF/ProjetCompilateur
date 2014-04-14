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
push -1
jmp $+4
push 0

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
push -1
jmp $+4
push 0

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
push -1
jmp $+4
push 0

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
push -1
jmp $+4
push 0

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
push -1
jmp $+4
push 0

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
push -1
jmp $+4
push 0

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
push -1
jmp $+4
push 0

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
push -1
jmp $+4
push 0

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

;iConst
push word ptr -1

;ior
pop ax 
pop bx
or ax,bx 
push ax

;iffaux SINON9
pop ax
cmp ax,0
je SINON9

;iConst
push word ptr 0

;iStore
pop ax
mov word ptr [bp-4],ax

;goto FSI9
jmp FSI9

SINON9:
;reserveRetour
sub sp,2

;iLoad
push word ptr [bp+4]

;call valeurde
call valeurde

;iStore
pop ax
mov word ptr [bp-6],ax

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp+6]

;iLoad
push word ptr [bp-6]

;isub
pop bx
pop ax
sub ax,bx
push ax

;iLoad
push word ptr [bp+4]

;call nbc
call nbc

;iStore
pop ax
mov word ptr [bp-4],ax

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp+6]

;iLoad
push word ptr [bp+4]

;iConst
push word ptr 1

;isub
pop bx
pop ax
sub ax,bx
push ax

;call nbc
call nbc

;iStore
pop ax
mov word ptr [bp-2],ax

;iLoad
push word ptr [bp-4]

;iLoad
push word ptr [bp-2]

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-4],ax

FSI9:

FSI8:

;iLoad
push word ptr [bp-4]

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
;ecrireChaine
.DATA
mess0 DB "donner le montant: $"
.CODE
lea dx,mess0
push dx
call ecrch

;aLaLigne
call ligsuiv

;lireEnt
lea dx,[bp-2]
push dx
call lirent

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp-2]

;iConst
push word ptr 7

;call nbc
call nbc

;iStore
pop ax
mov word ptr [bp-4],ax

;ecrireChaine
.DATA
mess1 DB "il y a $"
.CODE
lea dx,mess1
push dx
call ecrch

;iLoad
push word ptr [bp-4]

;ecrireEnt
call ecrent

;ecrireChaine
.DATA
mess2 DB " facons de changer $"
.CODE
lea dx,mess2
push dx
call ecrch

;iLoad
push word ptr [bp-2]

;ecrireEnt
call ecrent

;ecrireChaine
.DATA
mess3 DB ' francs.$"
.CODE
lea dx,mess3
push dx
call ecrch

;aLaLigne
call ligsuiv

;queue
nop
EXITCODE
end