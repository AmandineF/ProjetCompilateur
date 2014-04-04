extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE
 debut :
STARTUPCODE

;ouvrePrinc
mov bp,sp
sub sp,4

;ouvrePrinc
mov bp,sp
sub sp,4

;iConst
push word ptr 4

;iStore
pop ax
mov word ptr [bp-6],ax

;iLoad
push word ptr [bp-6]

;iConst
push word ptr 6

;isup
pop bx
pop ax
cmp ax,bx
jle $+6
push -1
jmp $+4
push 0

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iLoad
push word ptr [bp-6]

;goto FSI1
jmp FSI1

SINON1:
;iConst
push word ptr 6

FSI1:

;iConst
push word ptr 4

;iConst
push word ptr 6

;iinf
pop bx
pop ax
cmp ax,bx
jge $+6
push -1
jmp $+4
push 0

;iffaux SINON2
pop ax
cmp ax,0
je SINON2

;iConst
push word ptr 4

;goto FSI2
jmp FSI2

SINON2:
;iConst
push word ptr 6

FSI2:

;iConst
push word ptr 4

;iConst
push word ptr 6

;isup
pop bx
pop ax
cmp ax,bx
jle $+6
push -1
jmp $+4
push 0

;ouvrePrinc
mov bp,sp
sub sp,8

;ouvrePrinc
mov bp,sp
sub sp,8

;iConst
push word ptr 5

;iStore
pop ax
mov word ptr [bp-8],ax

;lireEnt
lea dx,[bp-10]
push dx
call lirent

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-8]

;iLoad
push word ptr [bp-10]

;iConst
push word ptr 5

;iLoad
push word ptr [bp-10]

;iLoad
push word ptr [bp-10]

;iConst
push word ptr 2

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-12],ax

;iConst
push word ptr 1

;iLoad
push word ptr [bp-8]

;iLoad
push word ptr [bp-10]

;iConst
push word ptr 5

;isub
pop bx
pop ax
sub ax,bx
push ax

;iLoad
push word ptr [bp-10]

;isub
pop bx
pop ax
sub ax,bx
push ax

;iLoad
push word ptr [bp-8]

;iConst
push word ptr 2

;imul
pop bx
pop ax
imul bx
push ax

;iLoad
push word ptr [bp-10]

;iLoad
push word ptr [bp-10]

;iLoad
push word ptr [bp-10]

;iStore
pop ax
mov word ptr [bp-14],ax

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-12]

;ecrireEnt
call ecrent

;aLaLigne
call ligsuiv

;iLoad
push word ptr [bp-14]

;ecrireEnt
call ecrent

;queue
nop
EXITCODE
End debut
