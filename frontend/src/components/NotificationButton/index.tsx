import { toast } from 'react-toastify';
import icon from '../../assets/images/notification-icon.svg';
import { api } from '../../service/api';

import './styles.css';

type TypeButtonProps = {
  saleId: number;
};

const NotificationButton: React.FC<TypeButtonProps> = ({ saleId }) => {
  const handleSaleNotification = async (saleId: number) => {
    await api.get(`/sales/${saleId}/notification`).then(response => {
      toast.success('SMS enviado com sucesso!');
    });
  };
  return (
    <>
      <div
        className='dsmeta-red-btn'
        onClick={() => handleSaleNotification(saleId)}
      >
        <img src={icon} alt='Notificar' />
      </div>
    </>
  );
};

export { NotificationButton };
